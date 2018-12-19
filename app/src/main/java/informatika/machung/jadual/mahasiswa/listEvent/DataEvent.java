package informatika.machung.jadual.mahasiswa.listEvent;

import java.util.ArrayList;

import informatika.machung.jadual.mahasiswa.listEvent.Event;

public class DataEvent {

        public static String[][] data = new String[][]{
                {
                    "Dr.Eng. Romy Budhi Widodo",
                    "Not Available",
                    "android.resource://informatika.machung.jadual/drawable/dosen_romy",
                    "Saya Romi"
                },

                {
                    "Hendry Setiawan, ST., M.Kom",
                    "Available in room",
                    "android.resource://informatika.machung.jadual/drawable/dosen_hendry",
                    "Hi Aku Hendry"
                }

        };

        public static ArrayList<Event> getListData(){
            Event event = null;
            ArrayList<Event> list = new ArrayList<>();
            for (int i = 0; i <data.length; i++) {
                event = new Event();
                event.setEvent_time(data[i][0]);
                event.setEvent_name(data[i][1]);

                list.add(event);
            }

            return list;
        }
}
