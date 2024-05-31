public class Item {
        private String name;
        private double price;
        private int index;

//Constructor
        public Item(String name, double price, int index) {
            this.name = name;
            this.price = price;
            this.index = index;
        }

//Getters And Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
        public int getIndex() {
            return index;
        }
    
        public void setIndex(int index) {
            this.index = index;
        }
    }
