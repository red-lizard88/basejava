/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if(storage[i] == null){
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        Resume rTemp = new Resume();
        rTemp.uuid = "Нет такого элемента в массиве.";
        for (Resume resume : storage) {
            if (resume != null) {
                if (resume.uuid.equals(uuid)) {
                    rTemp = resume;
                    break;
                }
            }
        }
            return rTemp;

    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if(storage[i] !=null) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i].uuid = null;
                    break;
                }
            }
        }
        Resume[] storageTemp = new Resume[10000];

        if(storage != null) {
            for (int j = 0; j < storageTemp.length; j++) {
                for (int i = 0; i < storage.length; i++) {
                    if (storage[i] != null) {
                        storageTemp[j] = storage[i];
                        break;
                    }
                }
            }
            storage = storageTemp;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if(storage[i] !=null){
                count++;
            }
        }
        Resume[] storageTemp = new Resume[count];
        for (int i = 0; i < storageTemp.length; i++) {
            storageTemp[i] = storage[i];
        }

        return storageTemp;
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if(storage[i] !=null){
                count++;
            }
        }
        return count;
    }
}
