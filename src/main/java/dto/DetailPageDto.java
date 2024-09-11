package dto;

public class DetailPageDto {
	private String movie_background;
	private String movie_title;
	private String release_year;
	private String genre_name;
	private String movie_time;
	private String age_name;
	private String poster;
	private String movie_description;
	private int score;
	public DetailPageDto(String movie_background, String movie_title, String release_year, String genre_name,
			String movie_time, String age_name, String poster, String movie_description, int score) {
		super();
		this.movie_background = movie_background;
		this.movie_title = movie_title;
		this.release_year = release_year;
		this.genre_name = genre_name;
		this.movie_time = movie_time;
		this.age_name = age_name;
		this.poster = poster;
		this.movie_description = movie_description;
		this.score = score;
	}
	public String getMovie_background() {
		return movie_background;
	}
	public void setMovie_background(String movie_background) {
		this.movie_background = movie_background;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public String getMovie_time() {
		return movie_time;
	}
	public void setMovie_time(String movie_time) {
		this.movie_time = movie_time;
	}
	public String getAge_name() {
		return age_name;
	}
	public void setAge_name(String age_name) {
		this.age_name = age_name;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMovie_description() {
		return movie_description;
	}
	public void setMovie_description(String movie_description) {
		this.movie_description = movie_description;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
