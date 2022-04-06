/**
 * @author Komorebi
 * @since 2021.08.09.20:37
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 * -------写在类上面的JavaDoc-------
 */

/**-------写在类上面的JavaDoc-------*/
/*
 *第一段：概要描述，通常用一句或者一段话简要描述该类的作用，以英文句号作为结束
 *第二段：详细描述，通常用一段或者多段话来详细描述该类的作用，一般每段话都以英文句号作为结束
 *详细描述中可以使用html标签，如<p>、<pre>、<a>、<ul>、<i> 等标签， 通常详细描述都以段落p标签开始.
 *第三段：文档标注，用于标注作者、创建时间、参阅类等信息
 *
 *@link： {@link 包名.类名#方法名(参数类型)}用于快速链接到相关代码
 *@link 的使用语法{@link 包名.类名#方法名(参数类型)}，其中当包名在当前类中已经导入了包名可以省略，
 *可以只是一个类名，也可以是仅仅是一个方法名，也可以是类名.方法名，使用此文档标记的类或者方法，
 *可用按住Ctrl键+鼠标单击快速跳到相应的类或者方法上，解析成html其实就是使用<code>包名.
 *类名#方法名(参数类型)</code>
 *
 *@code： {@code text}将文本标记为code
 *@code的使用语法 {@code text}会被解析成<code>text</code>
 *将文本标记为代码样式的文本，在code内部可以使用< 、>等不会被解释成html标签,code标签有自己的样式
 *一般在Javadoc中只要涉及到类名或者方法名，都需要使用@code进行标记.
 *
 *@param  一般类中支持泛型时会通过@param来解释泛型的类型
 *
 *@author 纯文本作者 邮件 组织 超链接邮件 超链接组织地址
 *@author<a href="mailto:ovidiu@cup.hp.com">Ovidiu Predescu</a>
 *
 *@see 一般用于标记该类相关联的类,@see即可以用在类上，也可以用在方法上。
 *
 *@since 一般用于标记文件创建时项目当时对应的版本，一般后面跟版本号，也可以跟是一个时间，表示文件当前创建的时间
 *
 *@version 用于标记当前版本，默认为1.0
 */

/**-------写在类上面的JavaDoc-------*/
/*
 * 第一段：概要描述，通常用一句或者一段话简要描述该方法的作用，以英文句号作为结束
 * 第二段：详细描述，通常用一段或者多段话来详细描述该方法的作用，一般每段话都以英文句号作为结束
 *       经常使用html标签，通常都以p标签开始，而且p标签通常都是单标签，不使用结束标签，
 *       其中使用最多的就是p标签和pre标签,ul标签, i标签。
 * 第三段：文档标注，用于标注参数、返回值、异常、参阅等
 *
 * pre标签可定义预格式化的文本。被包围在pre标签中的文本通常会保留空格和换行符.
 * pre标签的一个常见应用就是用来表示计算机的源代码。
 * 一般p经常结合pre使用，或者pre结合@code共同使用(推荐@code方式) 经常使用pre来举例如何使用方法
 * <pre>{@code
 *      Person[] men = people.stream()
 *                      .filter(p -> p.getGender() == MALE)
 *                      .toArray(Person[]::new);
 * }</pre>
 *
 * @param 后面跟参数名，再跟参数描述
 * @return 跟返回值的描述
 * @throws 跟异常类型 异常描述 , 用于描述方法内部可能抛出的异常
 * @exception 用于描述方法签名throws对应的异常
 * @deprecated 用于标注一个类或成员已过期,通常配合{@link}使用
 * @see 既可以用来类上也可以用在方法上，表示可以参考的类或者方法
 * {@value} 用于标注在常量上用于表示常量的值
 * @inheritDoc 用于注解在重写方法或者子类上，用于继承父类中的Javadoc
 *              基类的文档注释被继承到了子类
 *              子类可以再加入自己的注释（特殊化扩展）
 *              @return @param @throws 也会被继承
 */

public class Java文档注释 {
    public static void main(String[] args) {

    }
}
