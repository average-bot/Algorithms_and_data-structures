"""Shell."""
import random
import numpy
import time
import matplotlib.pyplot as plt
import math

import algorithms.BinarySearch as binarySearch
import algorithms.InstertionSort as insertionSort
import algorithms.MedianOfThreePivot as medianOfThreePivot
import algorithms.MergeSort as mergeSort
import algorithms.PivotArrayZero as pivotArrayZero

import algorithms.RandomPivot as randomPivot


class Shell:
    """Read input act accordingly."""

    def __init__(self):
        """Listen for input. Act accordingly."""
        while True:
            cmd = input(
                "Write auto for automatic testing or manual for manual input: "
            )
            if cmd == "auto":
                print("The tests will run automatically. Sit back and relax.")
                self.automatic_tests()

            elif cmd == "manual":
                print("Manually select the following-")
                self.manual_tests()
            else:
                print("Bad input.")

    def get_inputs(self, size, input_numbers=None):
        """Retrieve random numbers as input from the numbers.txt file(auto)."""
        if size != -1:
            random_numbers = []
            try:
                numbers_file = open("numbers.txt", "r")
                file_lines = numbers_file.readlines()
            except FileNotFoundError:
                print("File does not exist.")
                return
            for _ in range(size):  # 10 000 000 lines in numbers.txt
                random_numbers.append(
                    int(random.choice(file_lines).rstrip("\n"))
                )
            numbers_file.close()
            return random_numbers
        elif input_numbers is not None:
            return input_numbers

    def automatic_tests(self):
        """Automatic tests for the requires sheet."""
        input_sizes = [10, 100, 1000, 10000, 100000, 1000000]
        cycles = 5
        print("input sizes are: ", input_sizes)
        print("average of ", cycles, " cycles")
        print(
            "incase of a recursion error the output for the"
            "input size isn't shown."
        )

        medianOfThreePivot_times = self.bench_test(
            cycles=cycles,
            algorithm_type="median_of_three_pivot",
            input_sizes=input_sizes,
        )
        print("median of three pivot: ", medianOfThreePivot_times[0])
        self.draw_diagram(input_sizes, medianOfThreePivot_times[0])

        pivotArrayZero_times = self.bench_test(
            cycles=cycles,
            algorithm_type="pivot_array_zero",
            input_sizes=input_sizes,
        )
        print("array of first element pivot: ", pivotArrayZero_times[0])
        self.draw_diagram(input_sizes, pivotArrayZero_times[0])

        randomPivot_times = self.bench_test(
            cycles=cycles,
            algorithm_type="random_pivot",
            input_sizes=input_sizes,
        )
        print("random pivot: ", randomPivot_times[0])
        self.draw_diagram(input_sizes, randomPivot_times[0])

        merge_sort_times = self.bench_test(cycles, "merge_sort", input_sizes)
        print("merge sort: ", merge_sort_times[0])
        self.draw_diagram(input_sizes, merge_sort_times[0])

        insertion_sort_times = self.bench_test(
            cycles, "insertion_sort", input_sizes
        )
        print("insertion sort: ", insertion_sort_times[0])
        self.draw_diagram(input_sizes, insertion_sort_times[0])

        binary_times = self.bench_test(
            cycles=cycles,
            algorithm_type="binary_search",
            input_sizes=input_sizes,
            searched=random.randint(0, 100),
        )
        print("binary search: ", binary_times)
        self.draw_diagram(input_sizes, binary_times[0])

    def manual_tests(self):
        """Manual inputs testing from the keyboard."""
        input_numbers = []
        input_numbers = input("Enter a set of numbers divided by commas: ")
        input_numbers = input_numbers.rstrip().split(",")
        for x in range(len(input_numbers)):
            input_numbers[x] = int(input_numbers[x])
        cycles = int(input("Enter the amount of cycles: "))

        print(
            "1.median_of_three_pivot\n"
            "2.random_pivot\n"
            "3.pivot_array_zero\n"
            "4.insertion_sort\n"
            "5.merge_sort\n"
            "6.binary_search"
        )

        algorithm_nr = int(input("Enter the number for algorithm type: "))
        if algorithm_nr == 1:
            algorithm_type = "median_of_three_pivot"
        elif algorithm_nr == 2:
            algorithm_type = "random_pivot"
        elif algorithm_nr == 3:
            algorithm_type = "pivot_array_zero"
        elif algorithm_nr == 4:
            algorithm_type = "insertion_sort"
        elif algorithm_nr == 5:
            algorithm_type = "merge_sort"
        elif algorithm_nr == 6:
            algorithm_type = "binary_search"  # searched input a value below
            searched = int(input("Enter the searched integer value: "))
        else:
            return

        run_times, result = self.bench_test(
            cycles=cycles,
            algorithm_type=algorithm_type,
            input_numbers=input_numbers,
            searched=searched if algorithm_nr == 6 else None,
        )
        print("The runtime was: ", run_times[0], " seconds.")
        print(
            "The searched value was found: ", result
        ) if result is not None else None

    def bench_test(
        self,
        cycles,
        algorithm_type,
        input_sizes=None,
        input_numbers=None,
        searched=None,
    ):
        """Bench test an algorithm with rules. Return avrg sort times."""
        sort_times = []
        times = []
        if input_sizes is None:
            input_sizes = [-1]
        for size in input_sizes:
            for _ in range(cycles):
                numbers = self.get_inputs(
                    size=size, input_numbers=input_numbers
                )
                try:
                    start_time = time.perf_counter()
                    result = self.method_router(
                        name=algorithm_type,
                        numbers=numbers,
                        searched=searched,
                    )
                    end_time = time.perf_counter()
                except RecursionError:
                    break
                else:
                    times.append(end_time - start_time)
            result_times = list(
                filter(lambda time: (type(time) is float), times)
            )
            if len(result_times) != 0:
                sort_times.append(numpy.mean(result_times))
            times.clear()
        return sort_times, result

    def method_router(
        self, name, numbers, searched=None
    ):  # change parameters once the methods are changed
        """Switch for choosing a algorithmic method."""
        if name == "median_of_three_pivot":
            medianOfThreePivot.MedianOfThreePivot(numbers)
        elif name == "random_pivot":
            randomPivot.RandomPivot(numbers)
        elif name == "pivot_array_zero":
            pivotArrayZero.PivotArrayZero(numbers)
        elif name == "insertion_sort":
            insertionSort.InsertionSort(numbers)
        elif name == "merge_sort":
            mergeSort.MergeSort(numbers)
        elif name == "binary_search":
            bs = binarySearch.BinarySearch()
            found = bs.check_found(numbers, searched)
            return found
        return None

    def draw_diagram(self, input_sizes, runtimes):
        """Draw a matplotlib diagram with the information."""
        nr_of_input_sizes = len(runtimes)
        x = input_sizes[:nr_of_input_sizes]  # to make len(x) == len(y)
        y = runtimes
        x = numpy.array(x)
        y = numpy.array(y)
        default_x_ticks = range(len(x))
        plt.xlabel("Input sizes")
        plt.ylabel("Sort times")
        # plt.title("Quick sort") change
        plt.plot(default_x_ticks, y, marker="o")
        plt.xticks(default_x_ticks, x)
        plt.show()
