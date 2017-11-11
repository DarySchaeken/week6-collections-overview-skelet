package be.pxl.collections.linkedlist;

import java.util.LinkedList;

public class Browser {
	private LinkedList<Page> backward = new LinkedList<>();
	private LinkedList<Page> forward = new LinkedList<>();
	private Page currentPage;

	public Browser() {
		currentPage = new Page("www.google.be");
		showCurrentPage();
	}

	public void visit(String url) {
		backward.add(currentPage);
		currentPage = new Page(url);
		forward.clear();
	}

	public void showCurrentPage() {
		System.out.println("**** " + currentPage.url + " ****");
	}

	// implementeer de vorige en volgende functionaliteit van de browser
	public void back() {
		if (!backward.isEmpty()) {
			forward.add(currentPage);
			currentPage = backward.removeLast();
		}
	}

	public void forward() {
		if (!forward.isEmpty()) {
			backward.add(currentPage);
			currentPage = forward.removeLast();
		}
	}

	public Page getCurrentPage() {
		return currentPage;
	}

	private class Page {
		private String url;

		public Page(String url) {
			this.url = url;
		}
	}

}
