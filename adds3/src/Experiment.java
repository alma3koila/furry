

public class Experiment {


        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();

        public long measureSortTime(int[] arr, String type) {
            int[] copy = arr.clone();

            long start = System.nanoTime();

            if (type.equals("basic")) {
                sorter.basicSort(copy);
            } else {
                sorter.advancedSort(copy);
            }

            long end = System.nanoTime();
            return end - start;
        }

        public long measureSearchTime(int[] arr, int target) {
            long start = System.nanoTime();

            searcher.search(arr, target);

            long end = System.nanoTime();
            return end - start;
        }

        public void runAllExperiments() {

            int[] sizes = {10, 100, 1000};

            for (int size : sizes) {

                System.out.println("\n===== SIZE: " + size + " =====");

                int[] randomArr = sorter.generateRandomArray(size);
                int[] sortedArr = randomArr.clone();

                sorter.advancedSort(sortedArr); // sort for binary search

                // сорт тесты
                long basicTime = measureSortTime(randomArr, "basic");
                long advancedTime = measureSortTime(randomArr, "advanced");

                System.out.println("Bubble Sort Time: " + basicTime);
                System.out.println("Merge Sort Time: " + advancedTime);

                // поиск тест
                int target = sortedArr[size / 2];

                long searchTime = measureSearchTime(sortedArr, target);
                System.out.println("Binary Search Time: " + searchTime);
            }
        }
    }

