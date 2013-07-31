package com.wialon.messages;

public class UnitEvent extends Message {
	/* text of event */
	private String et;
	/* latitude */
	private double y;
	/* longitude */
	private double x;

	public UnitEvent () {
		this.messageType=MessageType.UnitEvent;
	}

	public String getEventText() {
		return et;
	}

	public double getLatitude() {
		return y;
	}

	public double getLongitude() {
		return x;
	}

	/** Message flags constants, unit event messages only */
	public static enum eventMessageFlag{
		/** AVL event type mask */
		typeMask(0x0F),
		/** AVL event message flag, set when event is simple event */
		typeSimple(0x0),
		/** AVL event message flag, set when event is violation */
		typeViolation(0x1),
		/** AVL event message flag, set when event is maintenance */
		typeMaintenance(0x2),
		/** AVL event message flag, set when event is route control update */
		typeRouteControl(0x4),
		/** AVL event message flag, set when event is unit driving info update */
		typeDrivingInfo(0x8),
		/** AVL maintenance event type mask */
		maintenanceMask(0x0),
		/** AVL event message flag, set when is event is maintenance-service */
		maintenanceService(0x10),
		/** AVL event message flag, set when is event is maintenance-filling */
		maintenanceFilling(0x20);
		/** Flag value */
		private long value;

		private eventMessageFlag (long value) {
			this.value=value;
		}

		public long getValue() {
			return value;
		}
	}
}
