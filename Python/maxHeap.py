class MaxHeap:

    def __init__(self, heap=[]):
        self.heap = heap
        self.up = 0
        self.down = 0
        for i in xrange(len(self.heap) / 2, len(self.heap)):
            self.bubbleUp(i)


    '''let the heap be max-heap when created for the first time'''
    def bubbleUp(self, child):
        self.up += 1
        if child == 0:
            return
        parent = (child - 1) // 2
        if self.heap[parent] < self.heap[child]:
            self.heap[parent], self.heap[child] = self.heap[child], self.heap[parent]
        self.bubbleUp(parent)


    '''
    max heapify the heap recursively
    :param index which the index of the parent that we want to make it max-heap
    '''
    def bubbleDown(self, parent):
        self.down += 1
        # if we're at the last level then return!
        if parent * 2 >= len(self.heap) - 1:
            return
        # the indexes of left and right child
        leftChild = parent * 2 + 1
        rightChild = parent * 2 + 2
        # keep track with the largest as it's going to be the parent
        largest = parent

        # let left child be the largest if it's
        if self.heap[largest] < self.heap[leftChild]:
            largest = leftChild

        # let right child be the largest if it's
        if self.heap[largest] < self.heap[rightChild]:
            largest = rightChild

        # no swaps needed we're done!
        if parent == largest:
            return
        # swap the current parent with the largest
        self.heap[largest], self.heap[parent] = self.heap[parent], self.heap[largest]
        # call it recursively
        self.bubbleDown(largest)

    '''
     change a value of a specific index
    :param index that need to be changed
    :param newValue that need to be replaced with the current value
    '''
    def changeIndexValue(self, index, newValue):
        if self.heap[index] < newValue:
            self.heap[index] = newValue
            self.bubbleUp(index)
        else:
            self.heap[index] = newValue
            self.bubbleDown(index)
