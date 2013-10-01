package playlist.controller;

import playlist.model.TracksDAO;
import playlist.model.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: stevelowenthal
 * Date: 9/19/13
 * Time: 5:22 PM
 *
 */
public class PlaylistsServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession httpSession = request.getSession(true);
    UserDAO user = (UserDAO) httpSession.getAttribute("user");

    // If we're not logged in, go to the login page
    if (user == null) {

      request.setAttribute("error", "Not Logged In");
      getServletContext().getRequestDispatcher("/login").forward(request,response);

    } else {

      UserDAO userFromDB = UserDAO.getUser(user.getEmail(), getServletContext());
      request.setAttribute("email", userFromDB.getEmail());
      request.setAttribute("playlist_names", userFromDB.getPlaylist_names());
      getServletContext().getRequestDispatcher("/playlists.jsp").forward(request,response);

    }
  }
}
