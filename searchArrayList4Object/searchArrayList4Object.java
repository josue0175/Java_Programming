import java.util.*;

public class ListExample {
    public static final void main(String[] args) {
        List<Friend>    list = new ArrayList<Friend>(5);
        String          targetCaption = "match";

        list.add(new Friend("match"));
        list.add(new Friend("non-match"));
        list.add(new Friend("match"));
        list.add(new Friend("non-match"));
        list.add(new Friend("match"));

        System.out.println("Before:");
        for (Friend f : list) {
            System.out.println(f.getFriendCaption());
        }

        Iterator<Friend> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getFriendCaption().equals(targetCaption)) {
                it.remove();
                //If you know it's unique, you could `break;` here
            }
        }
        System.out.println();
        System.out.println("After:");
        for (Friend f : list) {
            System.out.println(f.getFriendCaption());
        }
        
        System.exit(0);
}
    private static class Friend {
        private String friendCaption;

        public Friend(String fc) {
            this.friendCaption = fc;
        }

        public String getFriendCaption() {
            return this.friendCaption;
        }

    }
}


