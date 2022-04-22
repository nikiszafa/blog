package com.blog.niko.gwtfrontend.events;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;

public class EventBus {

	private EventBus() {

	}

	private static final SimpleEventBus INSTANCE = GWT.create(SimpleEventBus.class);

	public static SimpleEventBus getInstance() {

		return INSTANCE;

	}

}
