package resource;

import com.woniu.mybatis.entity.Category;
import com.woniu.mybatis.exception.ServiceException;
import com.woniu.mybatis.service.CategoryService;
import com.woniu.mybatis.service.ProxyFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @创建人 NST
 * @创建时间 2022/6/29
 * @描述
 */
@WebServlet("/admin/category")
public class AdminCategoryServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opr = req.getParameter("opr");
        if ("initAdd".equals(opr)) {
            doInitAdd(req, resp);
        } else if ("add".equals(opr)) {
            doAdd(req,resp);
        } else if ("del".equals(opr)) {
            doDel(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void doInitAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/JSP/initAdd.jsp").forward(req, resp);
    }

    private void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String navigation = req.getParameter("navigation");
        if (navigation == null) {
            navigation = "n";
        }
        Category category = new Category();
        category.setNavigation(navigation);
        category.setName(name);
        try {
            CategoryService categoryService = ProxyFactory.getProxy(CategoryService.class);
            categoryService.addCategory(category);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    private void doDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
