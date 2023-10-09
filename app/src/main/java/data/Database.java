package data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import models.Contact;
public class Database {

    public static SortedSet<Contact> contactList = new SortedSet<Contact>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<Contact> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(Contact contact) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends Contact> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean equals(@Nullable Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public Comparator<? super Contact> comparator() {
            return null;
        }

        @Override
        public SortedSet<Contact> subSet(Contact fromElement, Contact toElement) {
            return null;
        }

        @Override
        public SortedSet<Contact> headSet(Contact toElement) {
            return null;
        }

        @Override
        public SortedSet<Contact> tailSet(Contact fromElement) {
            return null;
        }

        @Override
        public Contact first() {
            return null;
        }

        @Override
        public Contact last() {
            return null;
        }


        public SortedSet<Contact> getContacts() {
            return contactList;
        }

        public void addContact(Contact contact) {
            contactList.add(contact);
        }

        public void removeContact(Contact contact) {
            contactList.remove(contact);
        }
    };






}
