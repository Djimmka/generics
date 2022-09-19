public class tester {
    public static class Box<T> {
        private T object;
        public static<T> Box<T> getBox(){
            Box<T> tBox = new Box<>();
            return tBox;
        }
    }
}
