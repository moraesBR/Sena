package senac.sena.models;

import android.os.Parcel;
import android.os.Parcelable;

public class EditModel implements Parcelable {
    private String editTextValue;
    private String textViewValue;
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getTextViewValue() {
        return textViewValue;
    }

    public void setTextViewValue(String textViewValue) {
        this.textViewValue = textViewValue;
    }

    public String getEditTextValue() {
        return editTextValue;
    }

    public void setEditTextValue(String editTextValue) {
        this.editTextValue = editTextValue;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.editTextValue);
        dest.writeString(this.textViewValue);
        dest.writeByte(this.valid ? (byte) 1 : (byte) 0);
    }

    public EditModel() {
    }

    protected EditModel(Parcel in) {
        this.editTextValue = in.readString();
        this.textViewValue = in.readString();
        this.valid = in.readByte() != 0;
    }

    public static final Creator<EditModel> CREATOR = new Creator<EditModel>() {
        @Override
        public EditModel createFromParcel(Parcel source) {
            return new EditModel(source);
        }

        @Override
        public EditModel[] newArray(int size) {
            return new EditModel[size];
        }
    };
}
