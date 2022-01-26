"""QuickSort algorithm."""
# Source: https://www.youtube.com/watch?v=COk73cpQbFQ&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=9&ab_channel=mycodeschool

# Recursive


class PivotArrayZero:
    """QuickSort."""

    def __init__(self, array):
        """Construct."""
        size = len(array)
        self.quick_sort(array, 0, size - 1)

    # function to find the partition position
    def partition(self, array, startIndex, endIndex):
        """Partition."""
        pivot = array[startIndex]
        array[startIndex], array[endIndex] = array[endIndex], array[startIndex]

        pIndex = startIndex
        for j in range(startIndex, endIndex):
            if array[j] <= pivot:
                array[pIndex], array[j] = array[j], array[pIndex]
                pIndex = pIndex + 1
        array[pIndex], array[endIndex] = array[endIndex], array[pIndex]

        return pIndex

    # function to perform quicksort
    def quick_sort(self, array, startIndex, endIndex):
        """Quicksort."""
        if startIndex < endIndex:

            # find pivot element such that
            # element smaller than pivot are on the left
            # element greater than pivot are on the right
            partitionIndex = self.partition(array, startIndex, endIndex)

            # recursive call on the left of pivot
            self.quick_sort(array, startIndex, partitionIndex - 1)

            # recursive call on the right of pivot
            self.quick_sort(array, partitionIndex + 1, endIndex)
