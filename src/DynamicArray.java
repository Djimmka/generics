import java.util.Arrays;

public class DynamicArray<T> {
    private int length = 0;
    private T[] elements = null;

    public DynamicArray () {
    }

    public DynamicArray (T[] elements) {
        this.elements = elements;
        length = elements.length;
    }


    public void add(T el) {
        if (length == 0) {
            elements = (T[])  new Object[10];
            elements[0] = el;
            length = 1;
        } else {
            if (elements.length >= length) {
                elements = Arrays.copyOf(Arrays.copyOf(elements, elements.length), length * 2);
            }
            elements[length++] = el;
        }
    }

    public void remove(int index) {
        T[] tmpArr = Arrays.copyOf(Arrays.copyOf(elements, index), elements.length);
        T[] tmpArr2 = Arrays.copyOfRange(elements, index + 1, elements.length);
        System.arraycopy(tmpArr2,0, tmpArr,index, tmpArr2.length);
        elements = tmpArr;
        length--;
    }



    public T get(int index) {
        if ((index < 0) || (index >= length)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elements[index];
    }
}
