"""Binary Search."""
# Source: https://www.geeksforgeeks.org/binary-search/


class BinarySearch:
    """BinarySearch."""

    def __init__(self):
        """Construct."""

    def check_found(self, numbers, searched):
        """Check if the number was found."""
        result = self.binary_search(numbers, 0, len(numbers) - 1, searched)
        if result != -1:
            found = True
        else:
            found = False
        return found

    def binary_search(self, numbers, left, right, searched):  # Recursive
        """Binarysearch algorithm."""
        if right >= left:  # Check base case
            mid = left + (right - left) // 2  # numbers[mid] was string why?
            # If element is present at the middle itself
            if numbers[mid] == searched:
                return mid
            # If element is smaller than mid, then it
            # can only be present in left subarray
            elif numbers[mid] > searched:
                return self.binary_search(numbers, left, mid - 1, searched)
            # Else the element can only be present
            # in right subarray
            else:
                return self.binary_search(numbers, mid + 1, right, searched)
        else:
            # Element is not present in the array
            return -1
