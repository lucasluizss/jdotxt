package com.todotxt.todotxttouch.task;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.chschmid.jdotxt.Jdotxt;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;
import org.junit.jupiter.*;

import static org.junit.Assert.*;

public class LocalFileTaskRepositoryTest {
	private static LocalFileTaskRepository localFileTaskRepository;
	final static String DEFAULTDIR = Jdotxt.DEFAULT_DIR;
	public static File TODO_TXT_FILE = new File(DEFAULTDIR + File.separator + "todo.txt");

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

	@Ignore
	@Test
	public void testStoreDoneTasks() {
		File file = new File(Jdotxt.DEFAULT_DIR + File.separator + "todo.txt");
		localFileTaskRepository.storeDoneTasks(file);
		assertNotNull(localFileTaskRepository);
	}

	@Ignore
	@Test
	public void testDoneFileModifiedSinceNull() {
		LocalFileTaskRepository repository = new LocalFileTaskRepository();
		boolean returned = repository.doneFileModifiedSince(null);
		assertEquals(0 < TODO_TXT_FILE.lastModified(), returned);
	}

	@Test
	public void testTodoFileModifiedSinceNull() {
		LocalFileTaskRepository repository = new LocalFileTaskRepository();
		boolean returned = repository.todoFileModifiedSince(null);
		assertEquals(0 < TODO_TXT_FILE.lastModified(), returned);
	}

	@Ignore
	@Test
	public void testTodoFileModifiedSinceFalse() {
		LocalFileTaskRepository repository = new LocalFileTaskRepository();
		boolean returned = repository.todoFileModifiedSince(new Date(100));
		assertTrue(returned);
	}

}
