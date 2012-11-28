package com.teamboid.twitterapi.dm;

import java.util.ArrayList;

public class ConversationOrganizer {

	public ConversationOrganizer(long myId) {
		convos = new ArrayList<Conversation>();
		this.myId = myId;
	}
	
	private ArrayList<Conversation> convos;
	private long myId;
	
	public void add(BaseMessage baseMessage) {
		int index = findConvoByThread(baseMessage.getThreadId());
		if(index > -1) {
			Conversation toSet = convos.get(index);
			toSet.addMessage(baseMessage);
			convos.set(index, toSet);
		} else {
			convos.add(new Conversation(baseMessage, myId));
		}
	}
	
	public void clear() {
		convos.clear();
	}
	
	public int findConvoByThread(String threadId) {
		for(int i = 0; i < convos.size(); i++) {
			if(convos.get(i).getThreadId().equals(threadId)) {
				return i;
			}
		}
		return -1;
	}
	
	public int findConvoByEndUser(long endUserId) {
		for(int i = 0; i < convos.size(); i++) {
			if(convos.get(i).getEndUserId() == endUserId) {
				return i;
			}
		}
		return -1;
	}
	
	public ArrayList<Conversation> getConvos() {
		return convos;
	}
}