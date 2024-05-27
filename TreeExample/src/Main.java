public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        //Inserimento di elementi
        fileSystem.insert(null, "root"); // Creazione root directory
        fileSystem.insert("root", "documents");
        fileSystem.insert("root", "pictures");
        fileSystem.insert("documents", "projects");
        fileSystem.insert("documents", "notes");
        fileSystem.insert("projects", "project1");

        // Stampa
        System.out.println("Print the file system in order:");
        fileSystem.printInOrder();

        // Ricerca
        String nameToSearch = "projects";
        if (fileSystem.search(nameToSearch)) {
            System.out.println("\nElement '" + nameToSearch + "' found in the file system.");
        } else {
            System.out.println("\nElement '" + nameToSearch + "' not found in the file system.");
        }
    }
}
