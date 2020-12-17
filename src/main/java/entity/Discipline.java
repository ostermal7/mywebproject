package entity;

public class Discipline {
    private String discName;
    private int discId;
    private boolean discStatus=true;

    public Discipline() {
    }

    public String getDiscName() {
        return discName;
    }

    public void setDiscName(String discName) {
        this.discName = discName;
    }

    public int getDiscId() {
        return discId;
    }

    public void setDiscId(int discId) {
        this.discId = discId;
    }

    public boolean isDiscStatus() {
        return discStatus;
    }

    public void setDiscStatus(boolean discStatus) {
        this.discStatus = discStatus;
    }

    public Discipline(String discName, int discId, boolean discStatus) {
        this.discName = discName;
        this.discId = discId;
        this.discStatus = discStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discipline that = (Discipline) o;

        if (discId != that.discId) return false;
        if (discStatus != that.discStatus) return false;
        return discName != null ? discName.equals(that.discName) : that.discName == null;
    }

    @Override
    public int hashCode() {
        int result = discName != null ? discName.hashCode() : 0;
        result = 31 * result + discId;
        result = 31 * result + (discStatus ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "discName='" + discName + '\'' +
                ", discId=" + discId +
                ", discStatus=" + discStatus +
                '}';
    }
}
