package com.example.PM_Base_App.data.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "action_table"
    //    indices = {@Index(name = "person_idx", value = {"person_id"})},
    //    foreignKeys = {@ForeignKey(entity = PersonEntity.class,
    //            parentColumns = {"person_id"},
     //           childColumns = {"person_id"},
     //           onDelete = ForeignKey.CASCADE)
     //   }
)
public class ActionEntity   implements Parcelable {

    // Properties

    @PrimaryKey(autoGenerate = true)
    private int action_id;

    private boolean active;
    private String name;
  //  private int person_id;

    // Constructors

    public ActionEntity(boolean active, String name, int person_id) {

        this.active = active;
        this.name = name;
      //  this.person_id = person_id;
    }

    // Methods

    public void setAction_id(int action_id) {

        this.action_id = action_id;
    }

 //   public int getPerson_id() {
 //       return person_id;
//    }

    public int getAction_id() {
        return action_id;
    }
    public Boolean getActive() {
        return active;
    }
    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.action_id);
        parcel.writeString(this.name);
        parcel.writeBoolean(this.active);
    }

    public ActionEntity() {
    }

    protected ActionEntity(Parcel parcel) {
        this.action_id = parcel.readInt();
        this.name = parcel.readString();
        this.active = parcel.readBoolean();
    }

    public static final Creator<ActionEntity> CREATOR = new Creator<ActionEntity>() {
        @Override
        public ActionEntity createFromParcel(Parcel parcel) {
            return new ActionEntity(parcel);
        }

        @Override
        public ActionEntity[] newArray(int size) {
            return new ActionEntity[size];
        }
    };

}
