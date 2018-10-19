package io.github.slawomirr;

public class Challenge9 {

    public static void main(String[] args) {
        final NewTutor tutor = new NewTutor();
        final NewStudent student = new NewStudent(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(tutor::studyTime);
        tutorThread.setName("tutorThread");

        Thread studentThread = new Thread(student::handInAssignment);
        studentThread.setName("studentThread");

        tutorThread.start();
        studentThread.start();
    }
}

class NewTutor {

    private NewStudent student;
    private boolean isStudentArrived = false;

    synchronized void setStudent(final NewStudent student) {
        this.student = student;
    }

    void studyTime() {
        System.out.println("Tutor has arrived");
        synchronized (this) {
            while (!isStudentArrived) {
                try {
                    // wait for student to arrive
                    this.wait();
                } catch (InterruptedException e) {

                }
            }
            student.startStudy();
            System.out.println("Tutor is studying with student");
        }
    }

    void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }

    synchronized void setStudentArrived(boolean studentArrived) {
        isStudentArrived = studentArrived;
    }
}

class NewStudent {

    private final NewTutor tutor;

    NewStudent(NewTutor tutor) {
        this.tutor = tutor;
    }

    void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    void handInAssignment() {
        tutor.getProgressReport();
        synchronized (tutor) {
            System.out.println("Student handed in assignment");
            tutor.setStudentArrived(true);
            tutor.notifyAll();
        }
    }
}
