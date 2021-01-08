package Internal;

interface BookingFactory{
    public void book();
}

interface BookingService{
    public void bookService();
}
class internal_tranform {

    private int i=1;

    public  class localBookingFactory implements BookingFactory{
        @Override
        public void book() {
            System.out.println("localBookingFactory");
        }
    }

    protected class RemoteBookingFactory implements BookingService{

        @Override
        public void bookService() {
            System.out.println("RemoteBookingFactory");
        }
    }

    public localBookingFactory getLocalBookingFactory(){
        return new localBookingFactory();
    }

    public RemoteBookingFactory getRemoteBookingFactory(){
        return new RemoteBookingFactory();
    }

    public static void main(String[] args) {
        //我们使用了接口，我们封装了内部类，也实现了多态，这里可以声明这个私有类localBookingFactory，因为main方法本身就是类的方法
        localBookingFactory e = new internal_tranform().getLocalBookingFactory();
        e.book();
        System.out.println(new internal_tranform().i);
        BookingFactory example=new internal_tranform().getLocalBookingFactory();
        example.book();

    }
}

class test{
    public static void main(String[] args) {
//        这里会出现报错你，因为本身localBookingFactory类就是私有的内部类，只有在外部(内部类的外部类)类下才可以访问到
        internal_tranform.localBookingFactory e = new internal_tranform().getLocalBookingFactory();
//        e.book();
//        但是你可以通过向上转型为接口来获取
        BookingFactory bookingFactory=new internal_tranform().getLocalBookingFactory();
        bookingFactory.book();
    }
}
