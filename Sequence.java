interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;


    Selector selector = new Selector() {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }
    };

    Selector selector2 = new Selector() {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            int i2 = items.length;

            if (i < i2 / 2) {
                Object temp = items[items.length - i - 1];
                items[items.length - i - 1] = items[i];
                items[i] = temp;
            }

            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }
    };


    public Selector getSelector() {
        return selector;
    }

    public Selector getSelectorReverse() {
        return selector2;
    }

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);

        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));

        while (!sequence.getSelector().end()) {
            System.out.print(sequence.getSelector().current() + " ");
            sequence.getSelector().next();
        }
        System.out.println();

        while (!sequence.getSelectorReverse().end()) {
            System.out.print(sequence.getSelectorReverse().current() + " ");
            sequence.getSelectorReverse().next();
        }

    }
}
