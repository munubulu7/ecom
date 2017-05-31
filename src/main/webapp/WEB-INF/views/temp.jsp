<c:if test="${catgory.subCategories.size()>0}">
	<div id="${catgory.targetId}" class="panel-collapse collapse">
		<div class="panel-body">
			<ul>
				<c:forEach items="${catgory.subCategories}" var="subCategory">
					<c:if test="${subCategory.active}">
						<li><a href="${subCategory.tergetLink}">${subCategory.displayName}</a>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
</c:if>