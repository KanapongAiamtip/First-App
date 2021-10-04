public enum Sign {
    O {
        @Override
        public Sign another() {
            return X;
        }
    },
    X {
        @Override
        public Sign another() {
            return O;
        }
    };

    public abstract Sign another();
}
