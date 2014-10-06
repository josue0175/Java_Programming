public class TestBook {
    public static void main(String[] args) {
        Author anAuthor = new Author("Josh Giles", "ahteck@somewhere.com", 'm');
        Book aBook = new Book("Dummy Java",anAuthor,19.95,1000);
            System.out.println("Book Name:" + aBook.getName());
            System.out.println("Book Author:" + aBook.getAuthor().getName());

            System.out.println("Book Price:" + aBook.getPrice());
            aBook.setPrice(109.99);
            System.out.println("Book Price:" + aBook.getPrice());
            System.out.println("Author email:" + aBook.getAuthor().getEmail());
            aBook.getAuthor().setEmail("newemail@blah.com");
            System.out.println("Printing object anAuthor directly:" + anAuthor);
            System.out.println("Printing object anAuthor indirectly:" + aBook.getAuthor().toString());

            System.out.println("using getAuthorName():" + aBook.getAuthorName());
    }
}
