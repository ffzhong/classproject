package playlist.model;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * DataStax Academy Sample Application
 *
 * Copyright 2013 DataStax
 *
 */


public class PlaylistDAO extends CassandraData {

  private String playlist_name;
  private String username;
  private int playlist_length_in_seconds;
  private List<Object> playlistTrackList;   // Changed to object for compilation

  public PlaylistDAO(String username, String playlist_name) {

    // Simple constructor to create an empty playlist
    this.username = username;
    this.playlist_name = playlist_name;
    playlist_length_in_seconds = 0;
    playlistTrackList = new ArrayList<>();

  }

  /**
   *
   * Create a new playlist
   *
   * @param user A userDAO object for the user that gets the new playlist
   * @param playlist_name The name of the new Playlist
   * @return  A PlaylistDAO object for the new playlist
   */
  public static PlaylistDAO createPlayList(UserDAO user, String playlist_name) {


    // Change single quotes to a pair of single quotes for escaping into the database
    String fixed_playlist_name = playlist_name.replace("'","''");

    // TODO
    // TODO - Add the playlist name to the playlist_names Set
    // TODO

    // Update the user object too

    user.getPlaylist_names().add(playlist_name);

    return new PlaylistDAO(user.getUsername(),playlist_name);

  }


  /**
   * Delete this playlist
   */
  public void deletePlayList() {

    // Change single quotes to a pair of single quotes for escaping into the database
    String fixed_playlist_name = this.playlist_name.replace("'","''");

    // TODO
    // TODO - Add code here to delete this playlist from the database
    // TODO

  }

  public UUID getUser_id() {
    return user_id;
  }

  public String getPlaylist_name() {
    return playlist_name;
  }

  public int getPlaylist_length_in_seconds() {
    return playlist_length_in_seconds;
  }

  public String getUsername() {
    return username;
  }

}
