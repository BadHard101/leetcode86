class MyWorkingSol {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head; // хотя бы 2 элемента

        ListNode fakeHead = new ListNode(0, head);
        ListNode lessX = null, greaterX = null, firstGreaterX = null, cur = head;
        while (cur != null) {
            if (cur.val < x) {
                if (lessX == null) { // если появился первый "белый" элемент
                    lessX = cur;
                    fakeHead.next = lessX; // то это head
                } else {
                    lessX.next = cur;
                    lessX = lessX.next;
                }
            } else {
                if (greaterX == null) {
                    greaterX = cur;
                    firstGreaterX = greaterX;
                } else {
                    greaterX.next = cur;
                    greaterX = greaterX.next;
                }
            }
            cur = cur.next;
        }

        // если есть "желтые", то последний должен вести в null, чтобы не зациклить ноды в круг
        if (firstGreaterX != null) {
            greaterX.next = null;
        }

        // если есть "белые"
        if (lessX != null) {
            lessX.next = firstGreaterX; // последний ведет в первый "желтый"
        } else {
            fakeHead.next = firstGreaterX; // иначе первый "желтый" это head
        }

        return fakeHead.next;
    }
}