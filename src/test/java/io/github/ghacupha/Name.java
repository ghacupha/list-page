package io.github.ghacupha;

class Name implements Indexable {

    private int index;
    private String name;

    @java.beans.ConstructorProperties( {"index", "name"})
    public Name(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public Name() {
    }

    public static NameBuilder builder() {
        return new NameBuilder();
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        final Name other = (Name) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (this.getIndex() != other.getIndex()) {
            return false;
        }
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Name;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getIndex();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "Name(index=" + this.getIndex() + ", name=" + this.getName() + ")";
    }

    public static class NameBuilder {
        private int index;
        private String name;

        NameBuilder() {
        }

        public NameBuilder index(int index) {
            this.index = index;
            return this;
        }

        public NameBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Name build() {
            return new Name(index, name);
        }

        public String toString() {
            return "Name.NameBuilder(index=" + this.index + ", name=" + this.name + ")";
        }
    }
}
