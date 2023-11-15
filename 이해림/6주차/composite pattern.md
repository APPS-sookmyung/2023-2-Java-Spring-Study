객체 지향 디자인 패턴 중에서 구조 패턴 중 하나.
구조 패턴은 전체의 계층을 하나의 인터페이스로 통합해서 트리구조로 구성하는 패턴, 개별 객체와 그 객체를 포함하는 복합 객체를 모두 동일하게 다룸.
이런 Composite Pattern의 가장 중요한 요소는 개별 객체를 표현할 수 있는 하나의 추상화 클래스를 정의하는 것.
이러한 패턴은 파일-폴더와 같이 전체의 객체 계통을 표현하고 싶을 때 사용하면 좋음.

(사친 참고)

Component: 집합 관계에 정의될 모든 객체에 대한 인터페이스를 정의, 모든 클래스에 해장하느 공통의 행동을 구현.
Leaf: 가장 말단 객체, 자식이 없고 객체 합성에 가장 기본이 되는 객체의 행동을 정의.
Composite: 자식이 있는 구정 요소에 대한 행동을 정의, 자신이 복합하는 요소들을 저장하면서, Component 인터페이스에 정의된 자식 관련 연산을 구현.

예제 -  인터페이스 구성하기
-FileSystem.java
package me.sup2is;

public interface FileSystem {

    void print();

}
파일과 폴더를 추사화한 FileSystem 인터페이스는 print()라는 추상메소드를 가짐.

-File.java
package me.sup2is;

public class File implements FileSystem {

    String name;

    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName() + "(" + name + ")");
    }

    public File(String name) {
        this.name = name;
    }
}
FileSystem을 구현하는 File 클래스 구현.

-Folder.java
older.java

package me.sup2is;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem {

    String name;

    private List<FileSystem> files = new ArrayList<>();

    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName() + "(" + name + ")");
        files.forEach(fileSystem -> fileSystem.print());
    }

    public void addFile(FileSystem file) {
        files.add(file);
    }

    public Folder(String name) {
        this.name = name;
    }
}
File 클래스는 단일 객체(Leaf)로 표현. 따라서 자신의 이름을 갖는 name 이라는 필드만 존재하고 Folder 클래스가 복합 객체(Composite)로 사용. 이 복합 객체는 FileSystem 타입의 리스트를 가짐.
인스턴스 메소드로 갖고 있는 addFile()은 FileSystem 타입의 인스턴스를 저장하는데 File과 Folder 모두 FileSystem 타입이기 떄문에 모두 들어올 수 있음.

예제 -  파일-폴더 구현하기
-Main.java
package me.sup2is;

public class Main {

    public static void main(String[] args) {

        Folder folder1 = new Folder("최상위 폴더");
        File myFile1 = new File("myFile1");
        File myFile2 = new File("myFile2");
        folder1.addFile(myFile1);
        folder1.addFile(myFile2);

        Folder folder2 = new Folder( "1depth");
        File myFile3 = new File("myFile3");
        File myFile4 = new File("myFile4");
        folder2.addFile(myFile3);
        folder2.addFile(myFile4);

        Folder folder3 = new Folder("2depth");
        File myFile5 = new File("myFile5");
        File myFile6 = new File("myFile6");
        folder3.addFile(myFile5);
        folder3.addFile(myFile6);

        Folder folder4 = new Folder("3depth");
        File myFile7 = new File("myFile7");
        File myFile8 = new File("myFile8");
        folder4.addFile(myFile7);
        folder4.addFile(myFile8);

        folder1.addFile(folder2);
        folder2.addFile(folder3);
        folder3.addFile(folder4);

        folder1.print();
        folder2.print();
        folder3.print();
    }
}
4개의 Folder 인스턴스와 각각 여러개의 File 인스턴스를 넣어서 파일-폴더 구조를 형성, File과 Folder는 모두 하나의 인터페이스로 통일되었기 때문에 folder1.addFile(folder2); 형태로 연결이 가능.

Composite Pattern의 장점은 사용자 입장에서 단일 객체인지 복합 객체인지 신경쓰지 않고 사용할 수 있음. 그러나, 설계가 지나치게 범용성을 갖기에 새로운 요소를 추가할 때 복합 객체에서 구성 요소에 제약을 갖기 힘듦.