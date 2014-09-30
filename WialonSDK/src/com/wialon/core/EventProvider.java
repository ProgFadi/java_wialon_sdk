package com.wialon.core;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EventProvider {
	private Map<Enum, List<EventHandler>> eventHandlers=new HashMap<Enum, List<EventHandler>>();

	/**
	 * Add listener to provider with selected type of event(s)
	 * @param eventHandler handler which will be called when event fired
	 * @param events type of events which want to listen
	 */
	public void addListener(EventHandler eventHandler, Enum... events) {
		for (Enum event : events){
			List<EventHandler> handlers=eventHandlers.get(event);
			if (handlers==null) {
				handlers=new ArrayList<EventHandler>();
				eventHandlers.put(event, handlers);
			}
			if (!handlers.contains(eventHandler))
				handlers.add(eventHandler);
		}
	}

	/**
	 * Removes handler from provider
	 * @param eventHandler handler which want to remove
	 * @param event event type
	 */
	public void removeListener(EventHandler eventHandler, Enum event){
		List<EventHandler> handlers=eventHandlers.get(event);
		if (handlers!=null)
			handlers.remove(eventHandler);
	}

	/**
	 * Removes listeners by event type
	 * @param event event type
	 */
	public void removeListeners(Enum event) {
		eventHandlers.remove(event);
	}

	/**
	 * Clearing listeners from event provider
	 */
	public void clearListeners() {
		eventHandlers.clear();
	}

	protected void fireEvent(Enum event, Object object, Object oldData, Object newData) {
		if (eventHandlers.get(events.All)!=null)
			for (EventHandler handler : eventHandlers.get(events.All))
				handler.onEvent(event, (object==null ? this : object), oldData, newData);
		if(eventHandlers.get(event)!=null) {
			for (EventHandler handler : eventHandlers.get(event))
				handler.onEvent(event, (object==null ? this : object), oldData, newData);
		}
	}

	public static enum events {
		All
	}
}
