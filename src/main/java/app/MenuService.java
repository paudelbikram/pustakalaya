package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MenuService {
    private static MenuService instance = new MenuService();
    private static HashSet<Book> menus;

    private MenuService(){
        menus = new HashSet<>();
        menus.add(new Book(1L, "Menu One"));
    }

    public static MenuService getInstance() {
        return instance;
    }

    public void add(Book menu) {
        menus.add(menu);
    }

    public List<Book> getAll() {
        return new ArrayList(menus);
    }

    public Book get(Long id) throws Exception {
        Iterator it = menus.iterator();
        while (it.hasNext()) {
            Book curr = (Book) it.next();
            if (curr.getId() == id)
                return curr;
        }
        throw new Exception("Object not found");
    }

    public boolean delete(Long id) throws Exception {
        Iterator it = menus.iterator();
        while (it.hasNext()) {
            Book curr = (Book) it.next();
            if (curr.getId() == id) {
                it.remove();
                return true;
            }
        }
        throw new Exception("Object not found");
    }

    public Book update(Long id, String update) throws Exception {
        Iterator it = menus.iterator();
        while (it.hasNext()) {
            Book curr = (Book) it.next();
            if (curr.getId() == id) {
                curr.setName(update);
                return curr;
            }

        }
        throw new Exception("Object not found");
    }
}
