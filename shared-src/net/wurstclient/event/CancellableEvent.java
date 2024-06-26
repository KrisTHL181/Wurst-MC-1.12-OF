/*
 * Copyright © 2014 - 2018 | Wurst-Imperium | All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.wurstclient.event;

public abstract class CancellableEvent<T extends Listener> extends Event<T>
{
	private boolean cancelled = false;
	
	public void cancel()
	{
		cancelled = true;
	}
	
	public boolean isCancelled()
	{
		return cancelled;
	}
}
