package in.purabtech.servlet;

import in.purabtech.entity.Book;
import in.purabtech.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        doProcess(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //	response.getWriter().append("Served at: ").append(request.getContextPath());

        String url = request.getServletPath();
        System.out.println(url + " request servlet path ");
        switch (url) {
            case "/login":
                loginAction(request, response);
                break;

            case "/logout":
                logoutAction(request, response);
                break;
            case "/register":
                registerAction(request, response);
                break;
            case "/deleteUser":
                deleteAction(request, response);
                break;
            case "/updateUserDetails":
                updateuserAction(request, response);
                break;

            case "/updateUser":
                updateUsersData(request, response);
                break;

            case "/addBooks":
                addBooks(request, response);
                break;

            case "/updateBook":
                updateBooks(request, response);
                break;

            case "/viewBooks":
                viewBooks(request, response);
                break;
            case "/deleteBook":
                deleteBook(request, response);
                break;
            case "/updateBookDetail":
                updateBookDetail(request, response);
                break;

            default:
                break;
        }

    }

    private void updateBookDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();
        try {
            Book book = (Book) request.getAttribute("book");
            manager.getTransaction().begin();
            Book bk= manager.find(Book.class, book.getBookId());
            bk.setBookPrice(book.getBookPrice());
            bk.setBookName(book.getBookName());
            bk.setBookAuthor(book.getBookAuthor());
            bk.setNumberOfCopies(book.getNumberOfCopies());
            bk.setEdition(book.getEdition());
            manager.merge(bk);
            List<Book> list=manager.createQuery("select a from Book a", Book.class).getResultList();
            manager.getTransaction().commit();
            request.setAttribute("books", list);

        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            manager.close();
        }
        request.getRequestDispatcher("viewBooks.jsp").forward(request, response);

    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();

        try {
            int id =Integer.parseInt(request.getParameter("bookid"));
            manager.getTransaction().begin();
            Book book = manager.find(Book.class, id);
            manager.remove(book);
            List<Book> list=manager.createQuery("select a from Book a", Book.class).getResultList();
            manager.getTransaction().commit();
            request.setAttribute("books", list);

        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            manager.close();
        }
        request.getRequestDispatcher("viewBooks.jsp").forward(request, response);

    }
    private void updateBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();
        try {
            int id =Integer.parseInt(request.getParameter("bookid"));
            manager.getTransaction().begin();
            Book book = manager.find(Book.class, id);
            request.setAttribute("book", book);
            manager.getTransaction().commit();

        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            manager.close();
        }
        request.getRequestDispatcher("updateBook.jsp").forward(request, response);
    }

    private void viewBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            List<Book> list=manager.createQuery("select a from Book a", Book.class).getResultList();
            manager.getTransaction().commit();
            request.setAttribute("books", list);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            manager.close();
        }
        request.getRequestDispatcher("viewBooks.jsp").forward(request, response);

    }



    private void addBooks(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();
        Book book = (Book) request.getAttribute("book");
        System.out.println(book.toString());
        try {
            manager.getTransaction().begin();
            book.setStatus("NEW");
            manager.persist(book);
            List<Book> listb=manager.createQuery("select a from Book a", Book.class).getResultList();
            request.setAttribute("books", listb);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            manager.close();
        }

        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    private void updateUsersData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        int id = Integer.parseInt(request.getParameter("userid"));
        System.out.println("request user to update " + id);
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();

        try {
            manager.getTransaction().begin();
            User user = (User)manager.find(User.class, id);
            manager.getTransaction().commit();
            request.setAttribute("user", user);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        request.getRequestDispatcher("update.jsp").forward(request, response);

    }

    private void updateuserAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        User user = (User) request.getAttribute("userData");
        System.out.println(user.getFullName() + " user full name and email : " + user.getEmail());

        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();

        try {

            manager.getTransaction().begin();
            manager.merge(user);
            manager.getTransaction().commit();

            HttpSession session = request.getSession();
            List<User> list = manager.createQuery("select a from User a", User.class)
                    .getResultList();

            session.setAttribute("list", list);
            response.sendRedirect("home.jsp");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            manager.close();
        }
    }

    private void deleteAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        int id = Integer.parseInt(request.getParameter("userId"));

        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();

        try {

            manager.getTransaction().begin();
            User user = manager.find(User.class, id);
            System.out.println("user exists"+ user.getEmail());
            manager.remove(user);
            manager.getTransaction().commit();

            HttpSession session = request.getSession();
            List<User> list = manager.createQuery("select a from User a", User.class)
                    .getResultList();

            session.setAttribute("list", list);
            response.sendRedirect("home.jsp");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            manager.close();
        }
    }

    private void registerAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();

        String operation = request.getParameter("option");
        User user = (User) request.getAttribute("userData");
        System.out.println(user.getFullName() + " user full name and email : " + user.getEmail());
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();


            System.out.println("User registered successfully...");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            manager.close();
        }

    }

    private void logoutAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        HttpSession session = request.getSession(false);
        session.removeAttribute("userid");
        session.invalidate();
        System.out.println("logout called");
        response.sendRedirect("index.jsp");
    }

    private void loginAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getAttribute("loginUser");
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager manager = emf.createEntityManager();
        String view="index.jsp";
        HttpSession session = request.getSession();
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select a from User a where username=:u and password=:p");
            query.setParameter("u", user.getUsername());
            query.setParameter("p", user.getPassword());
            User dbuser = null;
            dbuser = (User) query.getSingleResult();
            System.out.println("222222222222"+dbuser);
            if (dbuser !=null && dbuser.getUsername() != null) {
                List<Book> listb=manager.createQuery("select a from Book a", Book.class).getResultList();
                request.setAttribute("books", listb);
                if(dbuser.getRole().getRole().equals("ADMIN")) {
                    List<User> list = manager.createQuery("select a from User a", User.class).getResultList();
                    view="admin.jsp";
                    session.setAttribute("list", list);
                }else if (dbuser.getRole().getRole().equals("USER")) {
                    view="home.jsp";
                }
                session.setAttribute("userid", dbuser.getUsername());
                //response.sendRedirect(view);
            } else {

                session.setAttribute("succMsg", "No user found...");

                response.sendRedirect(view);
            }
            manager.getTransaction().commit();
        } catch (NoResultException e) {
            // TODO: handle exception
            e.printStackTrace();
            session.setAttribute("succMsg", "No user found...");
        } finally {
            if (manager.getTransaction().isActive())
                manager.getTransaction().rollback();
            manager.close();
        }
        System.out.println("111111111111111111111");
        request.getRequestDispatcher(view).forward(request, response);
    }
}
