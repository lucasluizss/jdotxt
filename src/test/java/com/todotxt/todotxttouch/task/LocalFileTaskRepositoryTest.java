package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.chschmid.jdotxt.Jdotxt;

public class LocalFileTaskRepositoryTest {
	private static LocalFileTaskRepository localFileTaskRepository;

	@Before
	public void setUp() {
		localFileTaskRepository = new LocalFileTaskRepository();
	}

	@Test
	public void testInit() {
		localFileTaskRepository.init();
		assertNotNull(localFileTaskRepository);
	}

	@Test
	public void testInitFiles() {
		localFileTaskRepository.initFiles();
		assertNotNull(localFileTaskRepository);
	}

	@Test
	public void testPurge() {
		localFileTaskRepository.purge();
		assertNotNull(localFileTaskRepository);
	}

	@Test
	public void testLoad() {
		localFileTaskRepository.load();
		assertNotNull(localFileTaskRepository);
	}

	@Test
	public void testLoadDone() {
		localFileTaskRepository.loadDoneTasks();
		assertNotNull(localFileTaskRepository);
	}

	@Test
	public void testStoreDone() {
		localFileTaskRepository.storeDoneTasks(new ArrayList<Task>());
		assertNotNull(localFileTaskRepository);
	}

	@Test
	public void testTodoFileModifiedSince() {
		localFileTaskRepository.todoFileModifiedSince(new Date());
		assertNotNull(localFileTaskRepository);
	}

	@Test
	public void testDoneFileModifiedSince() {
		localFileTaskRepository.doneFileModifiedSince(new Date());
		assertNotNull(localFileTaskRepository);
	}

	@Test
	public void testStoreDoneTasks() {
		File file = new File(Jdotxt.DEFAULT_DIR + File.separator + "todo.txt");
		localFileTaskRepository.storeDoneTasks(file);
		assertNotNull(localFileTaskRepository);
	}
}
