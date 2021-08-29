package com.mx.utaz.Controller;

import com.mx.utex.Model.Gadgets.BeanREG;
import com.mx.utex.Model.Address.BeanAddress;
import com.mx.utex.Model.Gadgets.DaoREG;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    private Map map = new HashMap();
    BeanREG BeanREG = new BeanREG();
    BeanAddress beanAddress = new BeanAddress();
    DaoREG DaoREG = new DaoREG();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch (action) {
            case "Registrar":
                String nombre = request.getParameter("nombre");
                String fecharegistro = request.getParameter("fecharegistro");
                String calle = request.getParameter("calle");
                String colonia = request.getParameter("colonia");
                int codigo_postal = Integer.parseInt(request.getParameter("codigo_postal"));
                String estado = request.getParameter("estado");
                String pais = request.getParameter("pais");

                BeanREG.setNombre(nombre);
                BeanREG.setFecharegistro(fecharegistro);

                beanAddress.setCalle(calle);
                beanAddress.setColonia(colonia);
                beanAddress.setcodigo_postal(codigo_postal);
                beanAddress.setEstado(estado);
                beanAddress.setPais(pais);

                BeanREG.setdireccion_fabricante(beanAddress);

                DaoREG.agregar(BeanREG);
                break;


            case "Listar":
                List<BeanREG> listGadgets = new DaoREG().Listar();
                map.put("listGadgets", listGadgets);
                write(response, map);
                map.clear();
                return;
            case "ListarId":
                int id = Integer.parseInt(request.getParameter("id"));
                map.put("Producto", new DaoREG().ListarId(id));
                write(response,map);
                map.clear();
                return;

            case "Modificar":
                int id1 = Integer.parseInt(request.getParameter("idproducto"));
                String nombre1 =  request.getParameter("nombre");
                String fecharegistro1 = request.getParameter("fecharegistro");
                String calle1 = request.getParameter("calle");
                String colonia1 = request.getParameter("colonia");
                int codigo_postal1 = Integer.parseInt(request.getParameter("codigo_postal"));
                String estado1 = request.getParameter("estado");
                String pais1 = request.getParameter("pais");

                BeanREG.setId(id1);
                BeanREG.setNombre(nombre1);
                BeanREG.setFecharegistro(fecharegistro1);

                beanAddress.setCalle(calle1);
                beanAddress.setColonia(colonia1);
                beanAddress.setcodigo_postal(codigo_postal1);
                beanAddress.setEstado(estado1);
                beanAddress.setPais(pais1);

                BeanREG.setdireccion_fabricante(beanAddress);

                DaoREG.modificar(BeanREG);
                request.getRequestDispatcher("/views/index.jsp").forward(request, response);
                break;
            case "Eliminar":
                int id2 = Integer.parseInt(request.getParameter("id"));
                DaoREG = new DaoREG();
                DaoREG.eliminar(id2);
                request.getRequestDispatcher("/views/index.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest(request,response);
        }


    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(map));
    }
}
