package com.realdolmen;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class TweetForDb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "person1_id")
	private Person1 username;

	private String message;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Jnd_TweetForDb_Tag", joinColumns = @JoinColumn(name = "TweetForDb_fk"), inverseJoinColumns = @JoinColumn(name = "Tag_fk"))
	private List<Tag> tags;

//	private String username;

	// @ElementCollection(fetch = FetchType.LAZY)
	// @CollectionTable(name = "Tag")
	// @Column(name = "Value")
	// private List<Tag> tags;

	private LocalDateTime date;

	@Enumerated(EnumType.STRING)
	private Enum status;

	protected TweetForDb() {

	}

	public TweetForDb(Person1 username, String message, List<Tag> tags) {
		this.username = username;
		this.message = message;
		this.tags = tags;
	}

	public Long getId() {
		return Id;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username.getFirstName();
	}

	public void setUsername(Person1 username) {
		this.username = username;
	}

	public LocalDateTime getDate() {
		return date = LocalDateTime.now();
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Enum getStatus() {
		return status;
	}

	public void setStatus(Enum status) {
		this.status = status;
	}

	public List<Tag> getTags() {
		return tags;
	}

}
