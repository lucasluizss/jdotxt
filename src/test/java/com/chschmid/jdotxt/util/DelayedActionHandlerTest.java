package com.chschmid.jdotxt.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import org.junit.BeforeClass;
import org.junit.Test;

public class DelayedActionHandlerTest {
	private static DelayedActionHandler delayedActionHandler;

	@BeforeClass
	public static void beforeClass() {
		delayedActionHandler = new DelayedActionHandler(1, new Action() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public Object getValue(String key) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void putValue(String key, Object value) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setEnabled(boolean b) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void addPropertyChangeListener(PropertyChangeListener listener) {
				// TODO Auto-generated method stub

			}

			@Override
			public void removePropertyChangeListener(PropertyChangeListener listener) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Test
	public void testTriggerAction() {
		delayedActionHandler.triggerAction();
		assertNotNull(delayedActionHandler);
	}

	@Test
	public void testCloseAction() {
		delayedActionHandler.close();
		assertNotNull(delayedActionHandler);
	}
}
