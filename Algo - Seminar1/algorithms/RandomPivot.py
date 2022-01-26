# Source: https://www.studytonight.com/python-programs/python-program-for-iterative-quicksort
"""Random Pivot Algorithm."""
import random

# Iterative


class RandomPivot:
    """Random Pivot."""

    def __init__(self, array):
        """Construct."""
        self.I_QuickSort(array, 0, len(array) - 1)

    def partition(self, array, low, high):
        """Partition."""
        i = low - 1

        randy = random.randint(low, high)
        pivot = array[randy]
        array[randy], array[high] = array[high], array[randy]

        for j in range(low, high):
            if array[j] <= pivot:

                i = i + 1
                array[i], array[j] = array[j], array[i]

        array[i + 1], array[high] = array[high], array[i + 1]
        return i + 1

    # low  --> Starting index,
    # high  --> Ending index
    def I_QuickSort(self, array, low, high):
        """Quicksort."""
        #  auxiliary stack
        size = high - low + 1
        stack = [0] * (size)

        top = -1

        top = top + 1
        stack[top] = low
        top = top + 1
        stack[top] = high

        # Keep popping from stack while is not empty
        while top >= 0:

            # Pop high and low
            high = stack[top]
            top = top - 1
            low = stack[top]
            top = top - 1

            # sorted array
            p = self.partition(array, low, high)

            # push left side to stack
            if p - 1 > low:
                top = top + 1
                stack[top] = low
                top = top + 1
                stack[top] = p - 1

            #  push right side to stack
            if p + 1 < high:
                top = top + 1
                stack[top] = p + 1
                top = top + 1
                stack[top] = high
