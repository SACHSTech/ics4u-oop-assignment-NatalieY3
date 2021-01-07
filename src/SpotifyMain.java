// spotify system 
// keeps track of user's songs, albums, podcasts
import java.util.Scanner;
import java.util.ArrayList;

public class SpotifyMain {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String selection;
		
		System.out.println("Hello Welcome to the Spotify User System. What is the name of the user?");
		
		User ourUser = new User();
		ourUser.setName(scan.nextLine());
		
		//infinite while loop for input/output
		while (true) {
			System.out.println("Enter Selection: Set data ? or Get data?. To exit enter nothing. Enter 'set' or 'get'");
			selection = scan.nextLine();
			
			if (selection.equalsIgnoreCase("set")) {
				System.out.println("set songs, albums, podcasts? Enter one. ");
				selection = scan.nextLine();
				if (selection.equalsIgnoreCase("songs")) {
					
					System.out.println("Enter the song name");
					Song newSong = new Song();
					newSong.setName(scan.nextLine());
					
					System.out.println("Enter the artist");
					newSong.setArtist(scan.nextLine());
					
					System.out.println("Enter the length (ex. '3:32')");
					newSong.setLength(scan.nextLine());
					
					ourUser.addToSongs(newSong);
					System.out.println("Song added. Select get option to view.");
					
				}
				else if (selection.equalsIgnoreCase("albums")) {
					System.out.println("Enter the name of an album");
					Album newAlbum = new Album();
					newAlbum.setName(scan.nextLine());
					
					System.out.println("Enter the artist");
					newAlbum.setArtist(scan.nextLine());
					
					System.out.println("Enter the number of tracks");
					newAlbum.setNumOfTracks(scan.nextLine());
					
					ourUser.addToAlbums(newAlbum);
					System.out.println("Album added. Select get option to view.");
				}
				else if (selection.equalsIgnoreCase("podcasts")) {
					System.out.println("Enter the name of a podcast");
					Podcast newPodcast = new Podcast();
					newPodcast.setName(scan.nextLine());
					
					System.out.println("Enter the artist");
					newPodcast.setArtist(scan.nextLine());
					
					System.out.println("Enter the length of the podcast (42:21 mins)");
					newPodcast.setLength(scan.nextLine());
					
					ourUser.addToPodcasts(newPodcast);
					System.out.println("Podcast added. Select get option to view.");
				}
				
			}
			else if (selection.equalsIgnoreCase("get")) {
				System.out.println("get songs, albums, podcasts? Enter one. ");
				selection = scan.nextLine();
				if (selection.equalsIgnoreCase("songs")) {
					System.out.println("Here are all songs saved");
					ourUser.getCollectionsOfData(selection);
				}
				else if (selection.equalsIgnoreCase("albums")) {
					System.out.println("Here are all albums saved");
					ourUser.getCollectionsOfData(selection);
				}
				else if (selection.equalsIgnoreCase("podcasts")) {
					System.out.println("Here are all podcasts saved");
					ourUser.getCollectionsOfData(selection);
				}
			}
			else {
				break;
			}
			
		}//close while 
		
		
	}//close main method
	
}//close SpotifyMain

class User {
	private String name;
		
	//using an arraylist instead of array so that length can be dynamically increased
	private ArrayList<Song> savedSongs = new ArrayList<Song>();
	private ArrayList<Album> savedAlbums = new ArrayList<Album>();
	private ArrayList<Podcast> savedPodcasts = new ArrayList<Podcast>();
	
	Scanner scan = new Scanner(System.in);
	
	public void setName(String value) {
		this.name = value;
	}
	public String getName() {
		return name;
	}
	
	public void addToSongs(Song song) {
		savedSongs.add(song);
	}
	
	public void addToAlbums(Album album) {
		savedAlbums.add(album);
	}
	public void addToPodcasts(Podcast podcast) {
		savedPodcasts.add(podcast);
	}
	
	public void getCollectionsOfData(String selection) {
		if (selection.equalsIgnoreCase("songs")) {
			for (Song someSong : savedSongs) {
				System.out.println(someSong.getName() + ", " + someSong.getArtist() + ", " + someSong.getLength());
			}
		}
		else if (selection.equalsIgnoreCase("albums")) {
			for (Album someAlbum : savedAlbums) {
				System.out.println(someAlbum.getName() + ", " + someAlbum.getArtist() + ", " + someAlbum.getNumOfTracks());
			}
		}
		else if (selection.equalsIgnoreCase("podcasts")) {
			for (Podcast somePodcast : savedPodcasts) {
				System.out.println(somePodcast.getName() + ", " + somePodcast.getArtist() + ", " + somePodcast.getLength());
			}
		}
	}
}//close User 

class Song extends User{
	private String artist,length;
	
	public void setArtist(String value) {
		this.artist = value;
	}
	
	public void setLength(String value) {
		this.length = value;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getLength() {
		return length;
	}
}//close album

class Album extends User{
	private String artist, numberOfTracks;
	
	public void setArtist(String value) {
		this.artist = value;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setNumOfTracks(String value) {
		this.numberOfTracks = value;
	}
	
	public String getNumOfTracks() {
		return numberOfTracks;
	}
}//close song
class Podcast extends User{
	private String artist,length;
	
	public void setArtist(String value) {
		this.artist = value;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setLength(String value) {
		this.length = value;
	}
	
	public String getLength() {
		return length;
	}
}//close podcast
