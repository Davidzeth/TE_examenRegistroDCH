package com.emergentes.controlador;

import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Deyvid
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");

        switch (op) {
            case "nuevo":
                request.setAttribute("miobjest", new Estudiante());
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                int id = Integer.parseInt(request.getParameter("id"));
                int pos = buscarPorIndice(request, id);
                Estudiante objest = lista.get(pos);
                request.setAttribute("miobjest", objest);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                int posEliminar = buscarPorIndice(request, idEliminar);
                if (posEliminar >= 0) {
                    lista.remove(posEliminar);
                }
                response.sendRedirect("index.jsp");
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = (Integer.parseInt(request.getParameter("id")));
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");
        Estudiante objest = new Estudiante();
        objest.setId(id);
        objest.setNombre(request.getParameter("nombre"));
        int primNot = (Integer.parseInt(request.getParameter("primNota")));

        if (primNot <= 30) {
            objest.setPriNota(primNot);
        } else {
            objest.setPriNota(0);// LA NOTA SE INVALIDARA COMO NULL (0)
        }
        int segNot = (Integer.parseInt(request.getParameter("segNota")));
        if (segNot <= 30) {
            objest.setSegNota(segNot);
        } else {
            objest.setSegNota(0);// LA NOTA SE INVALIDARA COMO NULL (0)
        }
        int terNot = (Integer.parseInt(request.getParameter("terNota")));
        if (terNot <= 40) {
            objest.setTerNota(terNot);
        } else {
            objest.setTerNota(0);// LA NOTA SE INVALIDARA COMO NULL (0)
        }

        if(primNot <=30 && segNot <= 30 && terNot <= 40){
            objest.setTotNota(primNot+segNot+terNot); // LA NOTA SE INVALIDARA COMO NULL (0)
        }

        if (id == 0) {
            int idNuevo = obtenerId(request);
            objest.setId(idNuevo);
            lista.add(objest);
        } else {
            int pos = buscarPorIndice(request, id);
            lista.set(pos, objest);
        }

        response.sendRedirect("index.jsp");
    }

    public int buscarPorIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");

        int pos = -1;

        if (lista != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    pos = i;
                    break;
                }
            }
        }
        return pos;
    }

    public int obtenerId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listaest");

        int idn = 0;
        if (lista != null && !lista.isEmpty()) {
            idn = lista.get(lista.size() - 1).getId();
        }
        return idn + 1;
    }
}
