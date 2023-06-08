package Main.Persistent;

import Main.Model.Order;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PersistentManager {
    public static void saveOrdersToFile() {
        Order toSave = (Order) Order.getAllOrders();
        Path storagePath = Path.of("orders.obj");

        try {
            if (!Files.exists(storagePath)) {
                Files.createFile(storagePath);
            }
            OutputStream os = Files.newOutputStream(storagePath);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(toSave);

            oos.close();
            os.close();
            System.out.println("Saved");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void loadOrdersFromFile() {
        Path storagePath = Path.of("orders.obj");

        if (Files.exists(storagePath)) {
            try {
                InputStream is = Files.newInputStream(storagePath);
                ObjectInputStream ois = new ObjectInputStream(is);

                Order loaded = (Order) ois.readObject();
                Order.setAllOrders((List<Order>) loaded);

                ois.close();
                is.close();
                System.out.println("Loaded");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
