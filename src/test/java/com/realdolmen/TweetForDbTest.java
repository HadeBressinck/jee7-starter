package com.realdolmen;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;

public class TweetForDbTest extends JpaPersistenceTest {

	@Test
	public void tweetCanBeRetrieved() throws Exception {
		// deze heeft een transactie openstaan, JpaPersistenceTest is van
		// leraren
		EntityManager em = entityManager();
		TweetForDb t = em.find(TweetForDb.class, 1000L);
		assertEquals("John", t.getUsername());
		assertEquals("I see purple haze", t.getMessage());
	}

	@Test
	public void tweetCanBePersisted() throws Exception {
		EntityManager em = entityManager();
		TweetForDb tweetForDb = new TweetForDb(new RegularPerson1(null, "Hade", "B", "pass", "h@mail.com"),
				"Tweet Toet", null);
		em.persist(tweetForDb);
	}

	@Test
	public void regularPersonCanBePersisted() throws Exception {
		RegularPerson1 p = new RegularPerson1(null, "Jimi", "Hendrix", "password", "jimi@gmail.com");
		entityManager().persist(p);
		entityManager().flush();
		entityManager().clear();
		assertNotNull(entityManager().find(RegularPerson1.class, p.getId()));
	}

	@Test
	public void verifiedPersonCanBePersisted() throws Exception {
		VerifiedPerson1 p = new VerifiedPerson1("Janis", "Joplin", "password", "janis@gmail.com", LocalDateTime.of(1946, 10, 15, 16, 32, 54), 1547854L, 23456);
		entityManager().persist(p);
		entityManager().flush();
		entityManager().clear();
		assertNotNull(entityManager().find(VerifiedPerson1.class, p.getId()));
	}

	@Test
	public void tweetCanBePersistedWithTag() throws Exception {
		EntityManager em = entityManager();
		List<Tag> list = new ArrayList<Tag>();
		Tag tag1 = new Tag("rdproud");
		list.add(tag1);
		TweetForDb tweetForDb = new TweetForDb(new RegularPerson1(null, "Jeroen", "B", "pass", "h@mail.com"),
				"Tweet Toet", list);
		em.persist(tag1);
		em.persist(tweetForDb);
	}

	@Test
	public void canRetrieveAndPersistDate() throws Exception {
		EntityManager em = entityManager();
		List<Tag> list = new ArrayList<Tag>();
		Tag tag1 = new Tag("");
		list.add(tag1);
		TweetForDb tweetForDb = new TweetForDb(new RegularPerson1(null, "Jeroen", "B", "pass", "h@mail.com"), "Tweeter",
				list);
		em.persist(tag1);
		em.persist(tweetForDb);
		TweetForDb tfd = em.find(TweetForDb.class, tweetForDb.getId());
		assertEquals(LocalDateTime.now().getYear(), tfd.getDate().getYear());
	}

	@Test
	public void canRetrieveAndPersistTagAndTestNameOfTag() throws Exception {
		EntityManager em = entityManager();
		List<Tag> list = new ArrayList<Tag>();
		Tag tag1 = new Tag("123");
		list.add(tag1);
		TweetForDb tweetForDb = new TweetForDb(new RegularPerson1(null, "Jeroen", "B", "pass", "h@mail.com"),
				"Tweeter2", list);
		em.persist(tag1);
		em.persist(tweetForDb);
		TweetForDb tfd = em.find(TweetForDb.class, tweetForDb.getId());
		assertEquals("123", tfd.getTags().iterator().next().getName());
	}

	@Test
	public void canRetrieveAndPersistTagsAndTestNamesOfTags() throws Exception {
		EntityManager em = entityManager();
		List<Tag> list = new ArrayList<Tag>();
		Tag tag1 = new Tag("123");
		Tag tag2 = new Tag("rdproud");
		em.persist(tag1); // kan vervangen worden door cascade bij TweetForDb ,
							// zie: Person1 bij TweetForDb
		em.persist(tag2);
		list.add(tag1);
		list.add(tag2);
		TweetForDb tweetForDb = new TweetForDb(new RegularPerson1(null, "Jeroen", "B", "pass", "h@mail.com"),
				"This is so much fun! I love DBs!", list);

		em.persist(tweetForDb);
		TweetForDb tfd = em.find(TweetForDb.class, tweetForDb.getId());
		Iterator<Tag> iterator = tfd.getTags().iterator();
		assertEquals("123", iterator.next().getName());
		assertEquals("rdproud", iterator.next().getName());
		// assertEquals("123", tfd.getTags().iterator().next().getName());
		// assertEquals("rdproud", tfd.getTags());
	}
}
