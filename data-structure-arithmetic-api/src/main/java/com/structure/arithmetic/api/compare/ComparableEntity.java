package com.structure.arithmetic.api.compare;

/**
 * @packageName：com.structure.arithmetic.api.compare
 * @desrciption:
 * @author: gaowei
 * @date： 2018-04-10 15:12
 * @history: (version) author date desc
 */
public class ComparableEntity implements Comparable<ComparableEntity> {

    private Long uuid;
    private String description;


    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(ComparableEntity o) {
        if (o == null && this.getUuid() == null && (this.getDescription() == null || this.getDescription() == "")) {
            return 0;
        } else {
            if (this.getUuid() != null && this.getUuid().compareTo(o.getUuid()) > 0) {
                return 1;
            }
            if (this.getDescription() != null && this.getDescription().compareTo(o.getDescription()) > 0) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ComparableEntity that = (ComparableEntity) o;

        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) {
            return false;
        }
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
