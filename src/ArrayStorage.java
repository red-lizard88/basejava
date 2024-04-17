import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
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
        for (Resume resume : storage) {
            if (resume != null) {
                if (resume.uuid.equals(uuid)) {
                    resume.uuid = null;
                    break;
                }
            }
        }

        Resume[] storageTemp = new Resume[10000];
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid != null) {
                    for (int j = 0; j < storageTemp.length - 1; j++) {
                        if (storageTemp[j] == null) {
                            storageTemp[j] = storage[i];
                            break;
                        }
                    }
                }
            }
        }
        storage = storageTemp;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                count++;
            }
        }
        Resume[] storageTemp = new Resume[count];
        System.arraycopy(storage, 0, storageTemp, 0, storageTemp.length);

        return storageTemp;
    }

    int size() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                count++;
            }
        }
        return count;
    }
}
