"""Insertion Sort."""
# Source: https://www.geeksforgeeks.org/python-program-for-insertion-sort/


class InsertionSort:
    """Insertion Sort."""

    def __init__(self, numbers):
        """Construct."""
        self.insertion_sort(numbers)

    def insertion_sort(self, array):  # Iterative
        """Insertionsort algorithm."""
        # Traverse through 1 to len(array)
        for key_index in range(1, len(array)):
            key_value = array[key_index]
            # Move elements of array[0..i-1], that are
            # greater than key, to one position ahead
            # of their current position
            end_key_index = key_index - 1
            while end_key_index >= 0 and key_value < array[end_key_index]:
                array[end_key_index + 1] = array[end_key_index]
                end_key_index -= 1
            array[end_key_index + 1] = key_value
