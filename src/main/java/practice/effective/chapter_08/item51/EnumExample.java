package practice.effective.chapter_08.item51;

public class EnumExample {

  public enum Status {
    SUCCESS,
    FAILURE
  }

  public static void main(String[] args) {
    Status status = performOperation(true);
  }

  // true/false가 뭘 뜻하는지 알 수 없다.
  private static Status performOperation(boolean isSuccess) {
    if (isSuccess) {
      return Status.SUCCESS;
    } else {
      return Status.FAILURE;
    }
  }

  private static Status goodPerformOperation(Status status) {
    if (status == Status.SUCCESS) {
      return Status.SUCCESS;
    } else {
      return Status.FAILURE;
    }
  }

}
