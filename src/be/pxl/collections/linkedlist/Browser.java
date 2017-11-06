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
        // pagina met de opgegeven url wordt de nieuwe currentPage van de browser
    }

    private void showCurrentPage() {
        System.out.println("**** " + currentPage.url + " ****");
    }

    // implementeer de vorige en volgende functionaliteit van de browser
    public void back() {
        
    }

    public void forward() {
      
    }


    private class Page {
        private String url;

        public Page(String url) {
            this.url = url;
        }
    }

}
